package com.mobidev.billing.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.Id

@Generated("com.robohorse.robopojogenerator")
@Entity
data class Owner(

	@field:JsonProperty("gists_url")
	val gistsUrl: String? = null,

	@field:JsonProperty("repos_url")
	val reposUrl: String? = null,

	@field:JsonProperty("following_url")
	val followingUrl: String? = null,

	@field:JsonProperty("starred_url")
	val starredUrl: String? = null,

	@field:JsonProperty("login")
	val login: String? = null,

	@field:JsonProperty("followers_url")
	val followersUrl: String? = null,

	@field:JsonProperty("type")
	val type: String? = null,

	@field:JsonProperty("url")
	val url: String? = null,

	@field:JsonProperty("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:JsonProperty("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:JsonProperty("avatar_url")
	val avatarUrl: String? = null,

	@field:JsonProperty("events_url")
	val eventsUrl: String? = null,

	@field:JsonProperty("html_url")
	val htmlUrl: String? = null,

	@field:JsonProperty("site_admin")
	val siteAdmin: Boolean? = null,

	@Id
	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("gravatar_id")
	val gravatarId: String? = null,

	@field:JsonProperty("organizations_url")
	val organizationsUrl: String? = null
)