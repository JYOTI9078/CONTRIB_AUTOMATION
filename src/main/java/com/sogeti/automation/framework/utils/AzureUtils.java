package com.sogeti.automation.framework.utils;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.sogeti.automation.framework.constants.AppConstants;

public class AzureUtils {
    Logging log = new Logging(AzureUtils.class.getName());

    public String getKeyVaultSecret(String secretName) {
        log.info("Creating SecretClient...");
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(AppConstants.AZURE_KEYVAULT_URL)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        log.info("Retrieving secret from Key Vault...");
        KeyVaultSecret secret = secretClient.getSecret(secretName);
        log.info("Secret received.");

        return secret.getValue();
    }
}
