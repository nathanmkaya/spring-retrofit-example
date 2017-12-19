package com.mobidev.billing.model.repos

import com.mobidev.billing.model.Owner
import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<Owner, Long> {
}