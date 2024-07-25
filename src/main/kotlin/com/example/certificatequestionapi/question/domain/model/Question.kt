package com.example.certificatequestionapi.question.domain.model

import com.example.certificatequestionapi.common.annotation.AllOpen
import com.example.certificatequestionapi.common.entity.BaseTime
import com.example.certificatequestionapi.common.enum.QuestionChapter
import com.example.certificatequestionapi.common.enum.QuestionType
import jakarta.persistence.*

@AllOpen
@Entity
@Table(name = "QUESTIONS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
abstract class Question(
    @Column(name = "question_text")
    val questionText: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", insertable = false, updatable = false)
    val questionType: QuestionType,

    @Enumerated(EnumType.STRING)
    @Column(name = "question_chapter")
    val questionChapter: QuestionChapter
) : BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0;

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val answers: MutableList<Answer> = mutableListOf();

    fun addAnswer(answerText: String) {
        val answer = Answer(answerText = answerText, question = this)
        answers.add(answer);
    }
}