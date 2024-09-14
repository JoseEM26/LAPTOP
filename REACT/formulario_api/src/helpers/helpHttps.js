const helpHttps = () => {
    const custonFetch = (endPoint, options) => {

        //HEADERS
        const defaultHeaders = {
            accept: "application/json",
            // headers:{"content-type":"application/json"}
        }

        options.headers = options.headers ?
            { ...options.headers, ...defaultHeaders } :
            defaultHeaders

        //METHOAD
        options.method = options.method || "GET";

        //SIGNAL
        let controller = new AbortController();
        options.signal = controller.signal;

        setTimeout(() => controller.abort(), 5000)

        //BODY
        options.body = JSON.stringify(options.body) || false;
        if (!options.body) delete options.body;


        return fetch(endPoint, options)
            .then((res) => 
                res.ok ?
                    res.json() :
                    Promise.reject({
                        error: true,
                        errorT: res.statusText,
                        errorN: res.status
                    })
            ).catch((err) => err);
    }

    const get = (url, options = {}) => {
        options.method = "GET"
        return custonFetch(url, options);
    }
    const post = (url, options = {}) => {
        options.method = "POST"
        return custonFetch(url, options);
    }
    const put = (url, options = {}) => {
        options.method = "PUT"
        return custonFetch(url, options);
    }
    const del = (url, options = {}) => {
        options.method = "DELETE"
        return custonFetch(url, options);
    }

    return {
        get, put, post, del
    };
};

export default helpHttps;