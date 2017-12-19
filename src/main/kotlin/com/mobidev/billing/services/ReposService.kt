package com.mobidev.billing.services

import com.mobidev.billing.model.Repo
import com.mobidev.billing.model.repos.OwnerRepository
import com.mobidev.billing.model.repos.RepoRepository
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class ReposService {

    @Autowired lateinit var repoRepository: RepoRepository
    @Autowired lateinit var ownerRepository: OwnerRepository
    val log = Logger.getLogger(ReposService::class.simpleName)

    fun saveAll(repos: List<Repo?>?) {
        log.info("Saving All Repos")
        repos?.forEach{i->
            ownerRepository.save(i?.owner)
            log.info("Saving $i")
            repoRepository.save(i)
        }
        //repos?.forEach{i-> repoRepository.save(i)}
        //repoRepository.save(repos)
    }

    fun getAll() : List<Repo> {
        log.info("Getting all Repos")
        return repoRepository.findAll()
    }

    fun getByQuery(qeury : String) : List<Repo> {
        return repoRepository.findByLanguage(qeury)
    }
}