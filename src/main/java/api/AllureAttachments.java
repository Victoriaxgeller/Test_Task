package api;

import io.qameta.allure.Attachment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureAttachments {

    private static Logger logger = LoggerFactory.getLogger(AllureAttachments.class);

    @Attachment(value = "{1}", type = "text/plain")
    public static String txtAttachment(String text, String name) {
        return text;
    }

    @Attachment(value = "{1}", type = "application/json")
    public static String json(String json, String name) {
        logger.info("(" + name + "): ");
        logger.info(json);
        return json;
    }

}
