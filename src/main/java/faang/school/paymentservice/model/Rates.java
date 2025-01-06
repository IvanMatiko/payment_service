package faang.school.paymentservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Rates {
    @JsonProperty("rates")
    private Map<String, BigDecimal> rates;
}
