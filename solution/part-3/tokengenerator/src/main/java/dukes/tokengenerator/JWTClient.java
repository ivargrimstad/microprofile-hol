package dukes.tokengenerator;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.UUID;

/**
 *
 */
public class JWTClient {

    public static void main(String[] args) throws IOException {

        PrivateKey key = readPrivateKey();
        String jwt = generateJWT(key);
        System.out.println(jwt);
    }

    private static String generateJWT(PrivateKey key) {
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .type(JOSEObjectType.JWT)
                .keyID("theKeyId")
                .build();

        MPJWTToken token = new MPJWTToken();
        token.setAud("targetService");
        token.setIss("https://server.example.com");  // Must match the expected issues configuration values
        token.setJti(UUID.randomUUID().toString());

        token.setSub("Jessie");  // Sub is required for WildFly Swarm
        token.setUpn("Jessie");

        token.setIat(System.currentTimeMillis());
        token.setExp(System.currentTimeMillis() + 30_000_000); // 30 000 Seconds expiration (about 8 hours)!

        token.addAdditionalClaims("custom-value", "Jessie specific value");

        token.setGroups(Arrays.asList("user", "protected"));

        JWSObject jwsObject = new JWSObject(header, new Payload(token.toJSONString()));

        // Apply the Signing protection
        JWSSigner signer = new RSASSASigner(key);

        try {
            jwsObject.sign(signer);
        } catch (JOSEException e) {
            e.printStackTrace();
        }

        return jwsObject.serialize();
    }

    public static PrivateKey readPrivateKey() throws IOException {

        InputStream inputStream = JWTClient.class.getResourceAsStream("/privateKey.pem");

        PEMParser pemParser = new PEMParser(new InputStreamReader(inputStream));
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(new BouncyCastleProvider());
        Object object = pemParser.readObject();
        KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
        return kp.getPrivate();
    }

}
