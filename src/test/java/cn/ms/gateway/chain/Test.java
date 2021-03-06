package cn.ms.gateway.chain;

import cn.ms.gateway.chain.entity.Request;
import cn.ms.gateway.chain.entity.Response;
import cn.ms.gateway.chain.impl.Test1Filter;
import cn.ms.gateway.chain.impl.Test2Filter;
import cn.ms.gateway.chain.impl.Test3Filter;

public class Test {

	public static void main(String[] args) throws Throwable {
		// 创建Request、Response对象
		Request req = new Request();
		Response resp = new Response();
		req.reqStr = "request";
		resp.respStr = "response";
		// 搞一个过滤链，链上有两个过滤器
		FilterChain<Request, Response> chain = new FilterChain<Request, Response>();
		chain.addFilter(new Test1Filter()).addFilter(new Test2Filter()).addFilter(new Test3Filter());
		// 开始过滤
		chain.doFilter(req, resp);
		System.out.println(req.reqStr);
		System.out.println(resp.respStr);
	}

}
