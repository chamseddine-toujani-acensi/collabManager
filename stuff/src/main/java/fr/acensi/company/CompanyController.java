package fr.acensi.company;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stuff/companies")
@AllArgsConstructor
@Slf4j
public class CompanyController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayOk() {
        return ResponseEntity.ok("Okkkkk");
    }
}
