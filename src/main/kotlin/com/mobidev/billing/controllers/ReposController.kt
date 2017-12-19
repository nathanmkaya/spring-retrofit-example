package com.mobidev.billing.controllers

import com.mobidev.billing.github.Client
import com.mobidev.billing.model.Repo
import com.mobidev.billing.model.Response
import com.mobidev.billing.services.ReposService
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult

@RestController
@RequestMapping("repos")
class ReposController {

    @Autowired lateinit var reposService: ReposService

    val log = Logger.getLogger(ReposController::class.simpleName)

    //@RequestMapping("/repos")
    /*fun getRepos(@RequestParam q : String) : List<Repo> {
        Client.getRepos(q)?.forEach {r ->
            run {
                repoRepository.save(r)
            }
        }
        return repoRepository.findAll()
    }*/

    @RequestMapping("/")
    fun getRepos(@RequestParam q : String) : DeferredResult<List<Repo>> {
        log.info("query parameter $q")
        val defResult = DeferredResult<List<Repo>>()
        Client.getReposAsync(q).subscribe(
                {t: Response? -> reposService.saveAll(t?.repos) },
                { error -> log.error(error)},
                { defResult.setResult(reposService.getAll())}
        )
        return defResult
    }

    @RequestMapping("/language")
    fun getRepoByLanguage(@RequestParam q : String) : DeferredResult<List<Repo>> {
        log.info("query parameter $q")
        val defResult = DeferredResult<List<Repo>>()

        Client.getReposAsync(q).subscribe(
                {t: Response? -> reposService.saveAll(t?.repos) },
                { error -> log.error(error)},
                { defResult.setResult(reposService.getByQuery(q))}
        )

        return defResult
    }
}