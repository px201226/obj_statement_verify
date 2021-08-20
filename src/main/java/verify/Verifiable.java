package verify;

import java.util.Set;

// 이 인터페이스를 구현한 객체는 상태 검증 가능한 객체가 된다.
@FunctionalInterface
public interface Verifiable {
	Set<VerifyType> verify();
}
