package kr.pe.paran.kbank.domain.use_case.test_case

import kr.pe.paran.kbank.data.repository.Repository

class TestCase(
    private val repository: Repository
) {

    suspend operator fun invoke() {
        // repository.....
    }

}