package co.za.entelect.utils;

import co.za.entelect.entities.UserEntity;
import co.za.entelect.repositories.UserRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public UserRepository userRepository(){ return new UserRepository() {
        @Override
        public Optional<UserEntity> findUserByPhoneNumber(String phoneNumber) {
            return Optional.empty();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserEntity> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<UserEntity> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public UserEntity getById(Long aLong) {
            return null;
        }

        @Override
        public UserEntity getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<UserEntity> findAll() {
            return null;
        }

        @Override
        public List<UserEntity> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends UserEntity> S save(S entity) {
            return null;
        }

        @Override
        public Optional<UserEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(UserEntity entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<UserEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<UserEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserEntity> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends UserEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    }
}