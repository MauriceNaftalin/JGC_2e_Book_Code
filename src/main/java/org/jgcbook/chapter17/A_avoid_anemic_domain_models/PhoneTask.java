package org.jgcbook.chapter17.A_avoid_anemic_domain_models;
// 19a3
import java.time.Duration;

public record PhoneTask(String name, String number, Duration duration) implements Task {
}