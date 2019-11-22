package za.co.bsg.raindrops.api

enum class ClientEndpoints(val uri: String, val key: String) {
    PERSONAL_INFO("https://my.api.mockaroo.com/personalInfo.json", "83c86d70"),
    DEPLOYMENTS("https://my.api.mockaroo.com/deployments.json", "83c86d70"),
    LOCATIONS("https://my.api.mockaroo.com/locations.json", "83c86d70")
}