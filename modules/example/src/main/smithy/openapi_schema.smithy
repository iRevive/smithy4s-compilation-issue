$version: "2.0"

namespace openapi_schema

use alloy.openapi#openapiExtensions
use smithytranslate#contentType

@openapiExtensions(
    "x-original-swagger-version": "2.0"
)
service OpenapiSchemaService {
    operations: [
        ClassificationsGet
    ]
}

/// Get status, results and metadata of a previously created classification
@openapiExtensions(
    "x-serviceIds": [
        "weaviate.classifications.get"
    ]
)
@http(
    method: "GET"
    uri: "/classifications/{id}"
    code: 200
)
operation ClassificationsGet {
    input: ClassificationsGetInput
    output: Unit
    errors: [
        ClassificationsGet403
        ClassificationsGet500
    ]
}

@error("client")
@httpError(403)
structure ClassificationsGet403 {
    @httpPayload
    @required
    @contentType("application/json")
    body: ErrorResponse
}

@error("server")
@httpError(500)
structure ClassificationsGet500 {
    @httpPayload
    @required
    @contentType("application/json")
    body: ErrorResponse
}

structure ClassificationsGetInput {
    /// classification id
    @httpLabel
    @required
    id: String
}

/// An error response given by Weaviate end-points.
structure ErrorResponse {
    error: Error
}

structure ErrorResponseErrorItem {
    message: String
}

list Error {
    member: ErrorResponseErrorItem
}
