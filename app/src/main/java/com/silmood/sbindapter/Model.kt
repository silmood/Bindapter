package com.silmood.sbindapter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class Game(val title: String,
                val steamRatingText: String,
                val metacriticScore: String,
                val steamRating: String)

class GameDataSource {

    companion object {
        fun getGames(): List<Game> {
            val type = object: TypeToken<List<Game>>(){}.type
            return Gson().fromJson<List<Game>>(GAMES_RESPONSE, type)
        }


        const val GAMES_RESPONSE = "[" +
                "{" +
                "\"internalName\": \"TOKITORI\"," +
                "\"title\": \"Toki Tori\"," +
                "\"metacriticLink\": \"/game/pc/toki-tori\"," +
                "\"dealID\": \"Ws%2B0c2sUsDPpqLQB7ToTCNhVsyc5uBSRe50G3FFDt58%3D\"," +
                "\"storeID\": \"1\"," +
                "\"gameID\": \"574\"," +
                "\"salePrice\": \"0.49\"," +
                "\"normalPrice\": \"4.99\"," +
                "\"isOnSale\": \"1\"," +
                "\"savings\": \"90.180361\"," +
                "\"metacriticScore\": \"80\"," +
                "\"steamRatingText\": \"Very Positive\"," +
                "\"steamRatingPercent\": \"88\"," +
                "\"steamRatingCount\": \"1289\"," +
                "\"releaseDate\": 1264636800," +
                "\"lastChange\": 1499708988," +
                "\"dealRating\": \"8.9\"," +
                "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/38700/capsule_sm_120.jpg?t=1488471030\"" +
                "}," +
                "{" +
                "\"internalName\": \"EDGE\"," +
                "\"title\": \"EDGE\"," +
                "\"metacriticLink\": \"/game/pc/edge\"," +
                "\"dealID\": \"RYs0QDQ8XYQoiP9CBjLKWuAQTgG1LFMQIYL3KBa1dNk%3D\"," +
                "\"storeID\": \"1\"," +
                "\"gameID\": \"320\"," +
                "\"salePrice\": \"0.69\"," +
                "\"normalPrice\": \"6.99\"," +
                "\"isOnSale\": \"1\"," +
                "\"savings\": \"90.128755\"," +
                "\"metacriticScore\": \"74\"," +
                "\"steamRatingText\": \"Very Positive\"," +
                "\"steamRatingPercent\": \"92\"," +
                "\"steamRatingCount\": \"1345\"," +
                "\"releaseDate\": 1313020800," +
                "\"lastChange\": 1499708988," +
                "\"dealRating\": \"8.6\"," +
                "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/38740/capsule_sm_120.jpg?t=1488470838\"" +
                "}," +
                "{" +
                "\"internalName\": \"ANTICHAMBER\"," +
                "\"title\": \"Antichamber\"," +
                "\"metacriticLink\": \"/game/pc/antichamber\"," +
                "\"dealID\": \"1uAVD1HNg2EWoHKkF7Fbra%2BEZhhCOrMv8PvCZNPMgbI%3D\"," +
                "\"storeID\": \"1\"," +
                "\"gameID\": \"94817\"," +
                "\"salePrice\": \"3.99\"," +
                "\"normalPrice\": \"19.99\"," +
                "\"isOnSale\": \"1\"," +
                "\"savings\": \"80.040020\"," +
                "\"metacriticScore\": \"82\"," +
                "\"steamRatingText\": \"Overwhelmingly Positive\"," +
                "\"steamRatingPercent\": \"96\"," +
                "\"steamRatingCount\": \"7724\"," +
                "\"releaseDate\": 1359590400," +
                "\"lastChange\": 1499966906," +
                "\"dealRating\": \"8.6\"," +
                "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/219890/capsule_sm_120.jpg?t=1447356555\"" +
                "}," +
                "{" +
                "\"internalName\": \"RUSH\"," +
                "\"title\": \"RUSH\"," +
                "\"metacriticLink\": \"/game/pc/rush\"," +
                "\"dealID\": \"U28trTScqykKVU5T28SH666NwfPIyUB4LvW5B47Tde0%3D\"," +
                "\"storeID\": \"1\"," +
                "\"gameID\": \"677\"," +
                "\"salePrice\": \"0.49\"," +
                "\"normalPrice\": \"4.99\"," +
                "\"isOnSale\": \"1\"," +
                "\"savings\": \"90.180361\"," +
                "\"metacriticScore\": \"73\"," +
                "\"steamRatingText\": \"Very Positive\"," +
                "\"steamRatingPercent\": \"89\"," +
                "\"steamRatingCount\": \"974\"," +
                "\"releaseDate\": 1291334400," +
                "\"lastChange\": 1499708989," +
                "\"dealRating\": \"8.5\"," +
                "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/38720/capsule_sm_120.jpg?t=1488470929\"" +
                "}]"

    }
}