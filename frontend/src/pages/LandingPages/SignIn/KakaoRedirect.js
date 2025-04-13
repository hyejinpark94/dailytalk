import React, { useEffect } from 'react';

const KakaoRedirect = () => {
  useEffect(() => {
    const code = new URL(window.location.href).searchParams.get('code');
    console.log('Authorization Code:', code);

    // 백엔드로 인가 코드 전달
    fetch('http://localhost:8080/api/kakao-login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ code }),
    })
      .then(response => response.json())
      .then(data => console.log('Access Token:', data))
      .catch(error => console.error('Error:', error));
  }, []);

  return <div>로그인 처리 중...</div>;
};

export default KakaoRedirect;
