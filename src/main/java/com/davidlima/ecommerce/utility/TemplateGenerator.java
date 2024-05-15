package com.davidlima.ecommerce.utility;

/**
 * Description of TemplateGenerator.
 *
 * @author David Lima
 */

public class TemplateGenerator {

  public static String generateTemplateConfirmationToken(String name, String url) {
    return "<html>\n" +
        "<body>\n" +
        "<h1>Hello " + name + ",</h1>\n" +
        "<p>Please click the button below to confirm your account:</p>\n" +
        "<a href=\"" + url + "\">" +  // Use double quotes for attribute value
        "<button>Confirm Account</button>" +
        "</a>\n" +
        "</body>\n" +
        "</html>";
  }
}
