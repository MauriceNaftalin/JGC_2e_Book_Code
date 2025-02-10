package org.jgcbook.chapter17.A_avoid_anemic_domain_models;
// 19a2
import java.time.Duration;

public record CodingTask(String spec, Duration duration) implements Task {
}