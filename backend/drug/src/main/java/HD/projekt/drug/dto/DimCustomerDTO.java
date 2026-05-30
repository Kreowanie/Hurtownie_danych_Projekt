package HD.projekt.drug.dto;

public record DimCustomerDTO(
        Integer id,
        Integer customerNo,
        Boolean isCustomerKnown,
        String customerType
) {
}