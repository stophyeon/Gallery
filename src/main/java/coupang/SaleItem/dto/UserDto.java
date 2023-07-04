package coupang.SaleItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserDto {
    String userName;
    String password;
    String email;
    String phoneNumber;
}
