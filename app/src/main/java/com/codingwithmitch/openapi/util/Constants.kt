package com.codingwithmitch.openapi.util

class Constants {

    companion object {
        const val BASE_URL: String = "https://open-api.xyz/api/"
        const val PASSWORD_RESET_URL: String = "https://open-api.xyz/password_reset/"
        const val PASSWORD_CHANGE_URL: String = "https://open-api.xyz/password_change/"
        const val CONFIRM_ACCOUNT_EXISTS_URL: String = "https://open-api.xyz/api/account/check_if_account_exists/"

        const val NETWORK_TIMEOUT = 3000L
        const val TESTING_NETWORK_DELAY = 0L // fake network delay for testing
        const val TESTING_CACHE_DELAY = 0L // fake cache delay for testing

        const val PAGINATION_PAGE_SIZE = 10

        const val GALLERY_REQUEST_CODE = 201
        const val PERMISSIONS_REQUEST_READ_STORAGE: Int = 301
        const val CROP_IMAGE_INTENT_CODE: Int = 401
    }
}





















