package kr.co.bullets.ringogtrust.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "프로파일 클래스", description = "배포시 현재 프로파일 확인 API")
public class ProfileConfig {

    @Value("${spring.profiles.active}")
    private String profile;


    @Operation(summary = "Profile API Summary", description = "현재 실행중인 프로파일 확인")
    @GetMapping("/profile")
    public String getProfile() {
        return profile;
    }
}
