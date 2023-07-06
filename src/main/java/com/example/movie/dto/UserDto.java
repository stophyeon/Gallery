package com.example.movie.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserDto {
    @NotBlank
    String userName;
    @Size(min=7)
    @NotBlank
    String password;
    @Email
    @NotBlank
    String email;
    @Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",message="-를 붙여주세요")
    @NotBlank
    String phoneNumber;
}
