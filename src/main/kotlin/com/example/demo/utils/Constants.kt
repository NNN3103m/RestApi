package com.example.demo.utils

class Constants {
    companion object{
        private const val URL_API_BASE="/api"
        private const val URL_API_VERSION="/v1"
        private const val URL_BASE= URL_API_BASE + URL_API_VERSION

        const val URL_BASE_CUSTOMERS    = "$URL_BASE/customers"
        const val URL_BASE_ITEMS        = "$URL_BASE/items"
        const val URL_BASE_SHOPS        = "$URL_BASE/shops"
    }
}