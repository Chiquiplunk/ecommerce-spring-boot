package com.davidlima.ecommerce.dto;

import com.davidlima.ecommerce.entity.Product;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description of PageDto.
 *
 * @author David Lima
 */

@Getter
@Setter
@NoArgsConstructor
public class PageDto<T> {

  private List<T> content;
  private boolean last;
  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private Long totalElements;

}
