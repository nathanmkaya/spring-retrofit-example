package com.mobidev.billing.api

import javassist.NotFoundException
import org.springframework.beans.ConversionNotSupportedException
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.validation.BindException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.ServletRequestBindingException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.async.AsyncRequestTimeoutException
import org.springframework.web.multipart.support.MissingServletRequestPartException
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException
import java.lang.Exception
import java.lang.IllegalStateException

@ControllerAdvice
class RestErrorExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = arrayOf(IllegalArgumentException::class, IllegalStateException::class, NotFoundException::class))
    protected fun handleConflict(ex: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        val bodyOfResponse = "This should be application specific"
        return handleExceptionInternal(ex, bodyOfResponse,
                HttpHeaders(), HttpStatus.CONFLICT, request)
    }

    /**
     * Customize the response for HttpMessageNotReadableException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleHttpMessageNotReadable(ex, headers, status, request)
    }

    /**
     * Customize the response for NoSuchRequestHandlingMethodException.
     *
     * This method logs a warning and delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleNoSuchRequestHandlingMethod(ex: NoSuchRequestHandlingMethodException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleNoSuchRequestHandlingMethod(ex, headers, status, request)
    }

    /**
     * Customize the response for MissingServletRequestParameterException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleMissingServletRequestParameter(ex: MissingServletRequestParameterException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleMissingServletRequestParameter(ex, headers, status, request)
    }

    /**
     * Customize the response for MissingPathVariableException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     * @since 4.2
     */
    override fun handleMissingPathVariable(ex: MissingPathVariableException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleMissingPathVariable(ex, headers, status, request)
    }

    /**
     * Customize the response for MethodArgumentNotValidException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleMethodArgumentNotValid(ex, headers, status, request)
    }

    /**
     * A single place to customize the response body of all Exception types.
     *
     * The default implementation sets the [WebUtils.ERROR_EXCEPTION_ATTRIBUTE]
     * request attribute and creates a [ResponseEntity] from the given
     * body, headers, and status.
     * @param ex the exception
     * @param body the body for the response
     * @param headers the headers for the response
     * @param status the response status
     * @param request the current request
     */
    override fun handleExceptionInternal(ex: Exception?, body: Any?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleExceptionInternal(ex, body, headers, status, request)
    }

    /**
     * Customize the response for ServletRequestBindingException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleServletRequestBindingException(ex: ServletRequestBindingException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleServletRequestBindingException(ex, headers, status, request)
    }

    /**
     * Customize the response for HttpMediaTypeNotSupportedException.
     *
     * This method sets the "Accept" header and delegates to
     * [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleHttpMediaTypeNotSupported(ex: HttpMediaTypeNotSupportedException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleHttpMediaTypeNotSupported(ex, headers, status, request)
    }

    /**
     * Customize the response for NoHandlerFoundException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     * @since 4.0
     */
    override fun handleNoHandlerFoundException(ex: NoHandlerFoundException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleNoHandlerFoundException(ex, headers, status, request)
    }

    /**
     * Customize the response for HttpMediaTypeNotAcceptableException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleHttpMediaTypeNotAcceptable(ex: HttpMediaTypeNotAcceptableException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request)
    }

    /**
     * Customize the response for BindException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleBindException(ex: BindException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleBindException(ex, headers, status, request)
    }

    /**
     * Customize the response for HttpRequestMethodNotSupportedException.
     *
     * This method logs a warning, sets the "Allow" header, and delegates to
     * [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleHttpRequestMethodNotSupported(ex: HttpRequestMethodNotSupportedException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request)
    }

    /**
     * Customize the response for MissingServletRequestPartException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleMissingServletRequestPart(ex: MissingServletRequestPartException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleMissingServletRequestPart(ex, headers, status, request)
    }

    /**
     * Customize the response for NoHandlerFoundException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param webRequest the current request
     * @return a `ResponseEntity` instance
     * @since 4.2.8
     */
    override fun handleAsyncRequestTimeoutException(ex: AsyncRequestTimeoutException?, headers: HttpHeaders?, status: HttpStatus?, webRequest: WebRequest?): ResponseEntity<Any> {
        return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest)
    }

    /**
     * Customize the response for ConversionNotSupportedException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleConversionNotSupported(ex: ConversionNotSupportedException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleConversionNotSupported(ex, headers, status, request)
    }

    /**
     * Customize the response for TypeMismatchException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleTypeMismatch(ex: TypeMismatchException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleTypeMismatch(ex, headers, status, request)
    }

    /**
     * Customize the response for HttpMessageNotWritableException.
     *
     * This method delegates to [.handleExceptionInternal].
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a `ResponseEntity` instance
     */
    override fun handleHttpMessageNotWritable(ex: HttpMessageNotWritableException?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        return super.handleHttpMessageNotWritable(ex, headers, status, request)
    }
}