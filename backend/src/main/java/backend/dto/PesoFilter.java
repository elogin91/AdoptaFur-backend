package backend.dto;

import org.springframework.data.util.Pair;

public enum PesoFilter {
	PEQUENA(0, 5), MEDIANA(5, 10), GRANDE(10, Integer.MAX_VALUE);

	Integer min, max;

	private PesoFilter(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public Pair<Integer, Integer> toPair() {
		return Pair.of(min, max);
	}
}
