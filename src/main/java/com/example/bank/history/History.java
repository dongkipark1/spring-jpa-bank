package com.example.bank.history;


import com.example.bank.account.Account;
import com.example.bank.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "history_tb")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender; // 꼭 account로 짓지 않아도 된다 계좌 1111 // 보낸이

    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver; // 계좌 2222 // 받는 이

    @Column(nullable = false)
    private Long amount; // 이체 금액

    // 이체 되었을 때 기록이 남아야 한다 SENDER에 JOIN해서 잔액을 표시하면 최종 잔액만 나옴
    @Column(nullable = false)
    private Long senderBalance; // 보낸이의 잔액 (그 시점에 남은 잔액)
    @Column(nullable = false)
    private Long receiverBalance; // 받는이의 잔액

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public History(Long id, Account sender, Account receiver, Long amount, Long senderBalance, Long receiverBalance, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.senderBalance = senderBalance;
        this.receiverBalance = receiverBalance;
        this.createdAt = createdAt;
    }
}
