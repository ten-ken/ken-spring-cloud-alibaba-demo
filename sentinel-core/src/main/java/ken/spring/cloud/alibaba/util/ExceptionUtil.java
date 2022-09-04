/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ken.spring.cloud.alibaba.util;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.alibaba.fastjson.JSON;
import ken.spring.cloud.alibaba.po.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangjian
 */
public final class ExceptionUtil {

	private ExceptionUtil() {

	}

	public static SentinelClientHttpResponse handleException(HttpRequest request,
			byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
		System.out.println("Oops: " + ex.getClass().getCanonicalName());
		List<User> list =new ArrayList<User>();
		User user =new User();
		user.setUserName("你已经被限流");
		list.add(user);
		return new SentinelClientHttpResponse(JSON.toJSONString(list));
	}

	public static SentinelClientHttpResponse fallbackException(HttpRequest request,
			byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
		System.out.println("Oops: " + ex.getClass().getCanonicalName());
		List<User> list =new ArrayList<User>();
		User user =new User();
		user.setUserName("你已经被服务降级");
		list.add(user);
		return new SentinelClientHttpResponse(JSON.toJSONString(list));
	}

}
