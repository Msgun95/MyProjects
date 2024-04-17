package Bright.AuthenticationService.dto;

import Bright.AuthenticationService.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotBlank(message = "firstname is required")
  @Size(min = 2, max = 20)
  private String firstName;
  @NotBlank(message = "lastname is required")
  @Size(min = 2, max = 20)
  private String lastName;


  @Size(min = 10, max = 40)
  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  @NotEmpty(message = "Email is required")
  private String email;
  @NotBlank(message = "Email is required")
  private String password;
  @NotBlank(message = "Email is required")
  private Role role;
}
