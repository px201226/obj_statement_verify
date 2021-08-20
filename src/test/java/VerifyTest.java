import static org.junit.jupiter.api.Assertions.*;

import entity.BizOrder;
import entity.BizSlip;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import verify.Verifier;
import verify.VerifyType;

public class VerifyTest {

	private Verifier verifier = new Verifier();

	@Test
	void biz_order_검증결과() {

		BizOrder bizOrder = new BizOrder(null, "dd", null);   // 검증 객체
		int expectExceptionCount = 1;

		Set<VerifyType> verifyResult = verifier.getVerifyResult(bizOrder);

		verifyResult.forEach(System.out::println);
		assertEquals(expectExceptionCount, verifyResult.size());
	}

	@Test
	void biz_order_리스트_검증결과() {

		List<BizOrder> bizOrderList = List.of(
				new BizOrder(null, null, null),
				new BizOrder("GOOD1", "GOOD1", new BizSlip()),
				new BizOrder("GOOD2", "GOOD2", new BizSlip()),
				new BizOrder("BAD", null, null),
				new BizOrder(null, "BAD", null),
				new BizOrder(null, null, new BizSlip())
		);

		Map<Integer, Set<VerifyType>> verifyResult =
				verifier.getVerifyResult(bizOrderList).entrySet().stream()
						.filter(a -> a.getValue().size() != 0)
						.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

		verifyResult.forEach((i, v) ->
				System.out.printf("%d 인덱스에 %s 예외 있음\n", i, v)
		);

		assertEquals(4, verifyResult.keySet().size());
	}
}
