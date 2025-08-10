package enset.ma.palmrecognitionserverapp.dto.request;

import enset.ma.palmrecognitionserverapp.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Integer type;

    @NotBlank
    private String password;

    private Integer acGroupNumber;
}
