import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.danilopianini.rrmxmx.Rrmxmx

class Test :
    StringSpec(
        {
            // from: https://archive.vn/DhXjB#selection-8831.1-8831.32
            "all tests of the original author should pass" {
                mapOf(
                    0x0000000000000000UL to 0x0000000000000000UL,
                    0x0000000000000001UL to 0x23085d6f7a569905UL,
                    0x56ed9162154faac0UL to 0x0000000000000001UL,
                    0x0000000000000003UL to 0xcaea878c77a59454UL,
                    0x0ec1bfbe6983c5a0UL to 0x0000000000000003UL,
                    0x0000000000000007UL to 0xa77bd5a63a7785c5UL,
                    0x1718113ac9a1f119UL to 0x0000000000000007UL,
                    0x0101010101010101UL to 0x36cb9e821eca6c5bUL,
                    0xfa63351a390851cdUL to 0x0101010101010101UL,
                    0x0123456789abcdefUL to 0xc337a528d7e42497UL,
                    0x7529d4da142b1f1cUL to 0x0123456789abcdefUL,
                    0x084c2a6e195d3b7fUL to 0x507d53f1ba22542cUL,
                    0xec3694cd1c80b9cdUL to 0x084c2a6e195d3b7fUL,
                    0x1000000000000001UL to 0xedd3f3f24766de89UL,
                    0xdb302dae3ad882e0UL to 0x1000000000000001UL,
                    0x1111111111111111UL to 0x7547f019c63c1df3UL,
                    0xea6d9bbf167027c9UL to 0x1111111111111111UL,
                    0x1fffffffffffffffUL to 0x05e3c8367d6677d6UL,
                    0x7fbbf24327033cf0UL to 0x1fffffffffffffffUL,
                    0x3fffffffffffffffUL to 0x47e7c1e973d349ffUL,
                    0x240ba915bbb5e089UL to 0x3fffffffffffffffUL,
                    0x6666666666666666UL to 0xd9c6e8c9ecd1e30aUL,
                    0xf4b9c6565f8d9529UL to 0x6666666666666666UL,
                    0x7777777777777777UL to 0x29823cb92ada0068UL,
                    0xdca549733043f019UL to 0x7777777777777777UL,
                    0x7f7f7f7f7f7f7f7fUL to 0xc58024da69c2eb57UL,
                    0xf1d5238b66aaaf5eUL to 0x7f7f7f7f7f7f7f7fUL,
                    0x7ffffffffffffff7UL to 0x30c8918fcb6b2b3cUL,
                    0x3a836e49ca560dd8UL to 0x7ffffffffffffff7UL,
                    0x7fffffffffffffffUL to 0x91b750beb6849d8fUL,
                    0x90354478a1b6e49dUL to 0x7fffffffffffffffUL,
                    0x8000000000000000UL to 0x5e2d59ded82568fcUL,
                    0xa0f3362cbce5bedbUL to 0x8000000000000000UL,
                    0x8000000000000008UL to 0xae03d8a5f03d42bbUL,
                    0xed1a6dc89b6e22d2UL to 0x8000000000000008UL,
                    0x8080808080808080UL to 0x269ed61ad0d4a3adUL,
                    0xcf8b0a0dccbf9da9UL to 0x8080808080808080UL,
                    0x8888888888888888UL to 0x2f6af135bf8e9d79UL,
                    0x2c50b3a1d5c7a854UL to 0x8888888888888888UL,
                    0x9999999999999999UL to 0x50a99564c864eb28UL,
                    0x6ae2b8e14b6d3c7cUL to 0x9999999999999999UL,
                    0xc000000000000000UL to 0xf5f0f95fcd968a80UL,
                    0x6ae70fea73bd7a6dUL to 0xc000000000000000UL,
                    0xe000000000000000UL to 0x160c347d11027361UL,
                    0x9a3d176b24d68305UL to 0xe000000000000000UL,
                    0xeeeeeeeeeeeeeeeeUL to 0x9f9714241fb64d9eUL,
                    0x0a40b8632cad4bfaUL to 0xeeeeeeeeeeeeeeeeUL,
                    0xeffffffffffffffeUL to 0x742025f2e92e6aecUL,
                    0xf7eaaefaaa16ddb8UL to 0xeffffffffffffffeUL,
                    0xf7b3d591e6a2c480UL to 0x60f421f08a38d500UL,
                    0xf520f63f955ac204UL to 0xf7b3d591e6a2c480UL,
                    0xfedcba9876543210UL to 0x8fec24c21c6d66deUL,
                    0xf18dbb478c6d3943UL to 0xfedcba9876543210UL,
                    0xfefefefefefefefeUL to 0x125c8836f02c998fUL,
                    0xe4b673f0521ad37dUL to 0xfefefefefefefefeUL,
                    0xfffffffffffffff8UL to 0x6018ed12f08b6eecUL,
                    0x1b32e354639f82f1UL to 0xfffffffffffffff8UL,
                    0xfffffffffffffffcUL to 0x420b85f7b23fa512UL,
                    0xe317247fad148210UL to 0xfffffffffffffffcUL,
                    0xfffffffffffffffeUL to 0xc320bdd84877d048UL,
                    0x31c9d93c42d48ceaUL to 0xfffffffffffffffeUL,
                    0xffffffffffffffffUL to 0x8bc57fddf83265bdUL,
                    0xb694bf1eaa6682c4UL to 0xffffffffffffffffUL,
                ).forEach { (base, result) ->
                    Rrmxmx.rrmxmx(base) shouldBe result
                    Rrmxmx.rrmxmx(base.toLong()) shouldBe result
                    Rrmxmx.hash(base) shouldBe result.toLong()
                    Rrmxmx.hash(base.toLong()) shouldBe result.toLong()
                }
            }
        },
    )
