package com.davidlima.ecommerce.utility;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Description of UrlGenerator.
 *
 * @author David Lima
 */

public class UrlGenerator {

  public static String create(String path, String queryName, String queryValue){

    return ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path(path)
        .queryParam(queryName,queryValue)
        .build()
        .toString();
  }
}
