package enset.ma.palmrecognitionserverapp.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimePeriodDto {

    @NotNull
    @Min(1) @Max(100)
    private Integer acTzNumber;

    @NotBlank
    private String acTzName;

    /* Sunday */
    private String sunStart;
    private String sunEnd;

    /* Monday */
    private String monStart;
    private String monEnd;

    /* Tuesday */
    private String tueStart;
    private String tueEnd;

    /* Wednesday */
    private String wedStart;
    private String wedEnd;

    /* Thursday */
    private String thursStart;
    private String thursEnd;

    /* Friday */
    private String friStart;
    private String friEnd;

    /* Saturday */
    private String satStart;
    private String satEnd;
}