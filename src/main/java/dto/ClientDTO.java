package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String nombres;
    private String apellidosPaterno;
    private String apellidosMaterno;
    private String edad;

}
