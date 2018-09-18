package com.example.bookstore.facades;

import com.example.bookstore.dto.RegisterVO;
import com.example.bookstore.entities.User;
import com.example.bookstore.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class UserFacadeTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserFacade userFacade;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void loadUserByUsername_shouldReturnAnUser_whenAUsernameIsGiven() {
        // Given
        final String username = "User";
        User user = new User(username, "password");
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);

        // When
        UserDetails userFound = userFacade.loadUserByUsername(username);

        // Then
        Mockito.verify(userRepository).findByUsername(username);
        assertThat(userFound).isEqualTo(user);
    }

    @Test
    public void loadUserByUsername_shouldThrowAnError_whenAUnknownUsernameIsGiven() {
        // Given
        final String username = "Unknown";
        Mockito.when(userRepository.findByUsername(username)).thenReturn(null);

        // When
        assertThatThrownBy(() -> userFacade.loadUserByUsername(username))

            // Then
            .hasMessage(username)
            .isInstanceOf(UsernameNotFoundException.class);

        Mockito.verify(userRepository).findByUsername(username);
    }

    @Test
    public void register_shouldAddAUser_givenAPasswordAndAnUsername() {
        // Given
        final String username = "user";
        final String password = "password";
        final String code = "code";
        final RegisterVO registerVO = new RegisterVO(username, password);
        Mockito.when(this.passwordEncoder.encode(password)).thenReturn(code);
        Mockito.when(this.userRepository.save(any(User.class))).thenReturn(null);

        // When
        this.userFacade.register(registerVO);

        // Then
        Mockito.verify(this.userRepository).save(any(User.class));
        Mockito.verify(this.passwordEncoder).encode(password);
    }
}
