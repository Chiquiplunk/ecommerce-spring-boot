package com.davidlima.ecommerce.controller;

import com.davidlima.ecommerce.entity.Category;
import com.davidlima.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of CategoryController.
 *
 * @author David Lima
 */

@Tag(name = "Category")
@AllArgsConstructor
@RestController
@RequestMapping("categories")

public class CategoryController {


  private CategoryService categoryService;

  @Operation(
      summary = "Obtener toda las categorias"
  )
  @GetMapping
  public ResponseEntity<List<Category>> getAll(){
    List<Category> categories = categoryService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(categories);
  }

  @Operation(
      summary = "Obtener categoria por ID",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Categoria encontrada",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Category.class)
              )
          ),

          @ApiResponse(
              responseCode = "404",
              description = "Categoria no encontrada",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResponse.class)
              )
          )
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(
      @Parameter(description = "Buscar Id de categoria")
      @PathVariable UUID id){
    Category categoryFound = categoryService.getById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(categoryFound);
  }
}
