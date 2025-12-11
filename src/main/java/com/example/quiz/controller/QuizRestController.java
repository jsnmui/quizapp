package com.example.quiz.controller;

import com.example.quiz.domain.Quiz;
import com.example.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {

    private final QuizService quizService;

    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getQuizzesByUserId(@RequestParam int userId) {
        List<Quiz> quizzes = quizService.getQuizzesByUserId(userId);
        return ResponseEntity.ok(quizzes);
    }
}

