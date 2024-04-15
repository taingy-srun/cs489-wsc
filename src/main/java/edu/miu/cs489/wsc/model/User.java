package edu.miu.cs489.wsc.model;

import edu.miu.cs489.wsc.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public UserDTO toUserDTO() {
        return new UserDTO(userId, username, role);
    }
}
