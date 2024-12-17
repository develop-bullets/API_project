package kr.co.bullets.ringogtrust;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Getter
@Setter
public class ProfileConfig {

    @Value("${spring.profiles.active}")
    private String profile;


    @GetMapping("/profile")
    public String getProfile() {
        return profile;
    }
}
