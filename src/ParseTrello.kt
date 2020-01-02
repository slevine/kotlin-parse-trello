package com.example

import com.fasterxml.jackson.module.kotlin.*
import java.io.*

fun main(args: Array<String>) {
    require(args.isNotEmpty()) { "A json file must be specified." }

    val mapper = jacksonObjectMapper()

    val json = mapper.readTree(File(args[0]))

    val listToName = json["lists"]
        .associate { Pair<String, String>(it["id"].asText(), it["name"].asText()) }

    val cardsToList = json["cards"]
        .toList()
        .filter { !it["closed"].asBoolean() }
        .groupBy { it["idList"] }

    cardsToList.values.toList().forEach { list ->

        println("--- ${listToName.getOrElse(list[0]["idList"].asText() ?: "") { "List Name Not Found" }} ---")

        list.forEach { card ->
            println(card["name"].asText())
            if (card["labels"].size() != 0)
                println(card["labels"].joinToString(", ") { label -> "#${label["name"].asText()}" })
            if (card["desc"].asText() != "")
                println(card["desc"].asText())
            if (card["attachments"].size() != 0)
                println(card["attachments"].joinToString { attachment -> "attachment: url: ${attachment["url"].asText()}" })
            println()
        }
    }
}