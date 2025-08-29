package br.com.casasbahia.crud_h2.controller.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "O NCM é obrigatório")
        @Pattern(regexp = "\\d{8}", message = "O NCM deve conter exatamente 8 dígitos")
        String ncm,

        @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres")
        String descricaoNcm,

        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @NotNull(message = "A quantidade é obrigatória")
        @Min(value = 0, message = "A quantidade não pode ser negativa")
        Integer quantidade
) {}