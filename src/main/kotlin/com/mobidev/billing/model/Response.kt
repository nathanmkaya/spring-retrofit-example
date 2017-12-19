package com.mobidev.billing.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Response(

	@field:JsonProperty("total_count")
	val totalCount: Int? = null,

	@field:JsonProperty("incomplete_results")
	val incompleteResults: Boolean? = null,

	@field:JsonProperty("items")
	val repos: List<Repo?>? = null
)