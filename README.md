# crudee

![image](https://user-images.githubusercontent.com/90130141/155438904-23d10357-cda9-452d-b93a-3882c08dca3d.png)


![image](https://user-images.githubusercontent.com/90130141/155438860-9538c7e7-5cfb-4345-a80b-1c93116522d9.png)

![image](https://user-images.githubusercontent.com/90130141/155438884-497ebba3-6979-43b3-94d3-e15db094c100.png)
> 어디서나 동작 : 컨테이너 이기 때문에 

![image](https://user-images.githubusercontent.com/90130141/155439471-f2b67da9-a558-4183-aa40-1e37ce9fc6d6.png)


![image](https://user-images.githubusercontent.com/90130141/155439928-90d26b21-8621-4394-9518-5f0df4e88ceb.png)
![image](https://user-images.githubusercontent.com/90130141/155440354-a3cf7c1c-8156-4c60-8188-26b77f45a248.png)
![image](https://user-images.githubusercontent.com/90130141/155443048-83cf0a36-1598-4578-9878-b3ae1ee3ccf0.png)
![image](https://user-images.githubusercontent.com/90130141/155443961-8dda5431-5193-456c-884d-1191d0f54461.png)
![image](https://user-images.githubusercontent.com/90130141/155444108-9ead4730-af51-4ac3-a4d1-bb0e05fc506c.png)
![image](https://user-images.githubusercontent.com/90130141/155445089-c1a4471d-b739-448c-a1aa-1cd83a2f2f51.png)


> replicationcController 가 파드 개수를 유지 시켜주고
> 서비스가 로드밸런싱을 통해 분산해준다.


파드들은 워커노드에 스케줄링이 된다





파드 안에 컨테이너가 들어간다 : 신의 한 수 


- 마스터
    
    <aside>
    ✅ 노드에 배포된 컨테이너를 관리하는 역할을 합니다.
    
    </aside>
    
- 노드
    
    <aside>
    ✅ 컨테이너가 배포되는 환경을 제공합니다.
    
    </aside>
    
- 파드
- 
    <aside>
    ✅ 파드(Pod)는 쿠버네티스에서 생성하고 관리할 수 있는 배포 가능한 가장 작은 컴퓨팅 단위입니다.
    
    </aside>

![image](https://user-images.githubusercontent.com/90130141/155440089-e6a91ea1-ede6-45c4-88c9-75c847e305da.png)
> etcd : 메타정보 관리 깨지면 클러스트도 망가짐
> API Server : 마스터 노드 
> kube-proxy: 네트워크 담당 ,
> kublet : 컨테이너 런타임을 관리해준다/

이미지

특정 기능을 하기위한 프로그램들의 모음 - 
레파지토리로 분류를 한다 (NGINX) 


이미지를 로컬로 다운받고 컨테이너로 구동을 한다

컨테이너 실행과정

도커는 호스트 os에 있는 다른 프로세스와 다르게 완전히 격리된 환경을 제공한다.

 엔트리 1 번

CMD 는 아규먼트 오버라이딩 가능 

국내에서 msa 개발하면 스프링

Istio 서비스 mesh 솔루션 	



