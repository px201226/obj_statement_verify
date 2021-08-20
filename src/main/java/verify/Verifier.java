package verify;


import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

// 객체 상태를 검증기
public class Verifier {

	public Set<VerifyType> getVerifyResult(Verifiable verifiable){
		return verifiable.verify();
	}

	public Map<Integer, Set<VerifyType>> getVerifyResult(Collection<? extends Verifiable> verifiables){

		AtomicInteger rowIdx = new AtomicInteger(0);

		// Map<예외가 발생된 리스트 번호, 예외타입>
		Map<Integer, Set<VerifyType>> results =
				verifiables.stream().collect(toMap(v -> rowIdx.incrementAndGet(), v -> getVerifyResult(v)));

		return results;
	}
}
