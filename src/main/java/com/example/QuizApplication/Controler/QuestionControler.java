    package com.example.QuizApplication.Controler;

    import com.example.QuizApplication.model.Qutions;
    import com.example.QuizApplication.service.QuettionService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("Question")
    public class QuestionControler {
        @Autowired
        QuettionService quettionService;

        @GetMapping("allquestion")
    public ResponseEntity<List<Qutions>> getAllQution()
    {
    return quettionService.getAllQution();
    }

        @GetMapping("category/{category}")
    public ResponseEntity<List<Qutions>> getbyQutionCategory(@PathVariable String category)
        {
            return quettionService.getbyQutionCategory(category);
        }

        @PostMapping("add")
        public ResponseEntity<String> addQuestion(@RequestBody Qutions qutions)
        {
           return quettionService.addQuestion(qutions);
        }
    }
