package com.satoken.enums

enum class SourceEnum(
    override val value: Int,
    val label: String
) : BasicEnum<Int> {
    WEB(1, "web"),
    APP(2, "app"),
}
